//package com.jyh.jiangboot.temp;
//
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//
//import java.time.LocalDateTime;
//import java.util.*;
//
//public class Temp1 {
//
//
//    /**
//     * python 逻辑
//     * @param need2change
//     * @param userIds
//     * @param cells
//     * @return
//     */
//    public boolean updateAndRemoveDidiInformation(Boolean need2change, List<Integer> userIds, List<String> cells) {
//        if (need2change == null) {
//            need2change = false;
//        }
//
//        String mailConntent = "员工滴滴同步开始-" + DateTimeUtil.date2String(LocalDateTime.now());
//        mailSendService.sendMail("员工滴滴同步开始-" + DateTimeUtil.date2String(LocalDateTime.now()), mailConntent, syncMail);
//
//        List<User> users = userService.getUserByIdsAndCells(userIds, cells);
//
//        String token = didiRestClient.getToken();
//        List<Map<String, String>> warningUserList = new ArrayList<>();
//
//        int totalUser = 100;
//        int lenUser = 0;
//        Map<String, JSONObject> didiUsers = new HashMap<>();
//        while (totalUser > lenUser) {
//            JSONObject data = didiRestClient.getMemberFromDidi(token, null, lenUser, null);
//            totalUser = data.getInteger("total");
//
//            JSONArray didiMembers=((JSONArray) data.get("records"));
//            for (Object didiUser : didiMembers) {
//                JSONObject user = (JSONObject) didiUser;
//                didiUsers.put(user.getString("employee_number"), user);
//                lenUser += 1;
//            }
//
//        }
//
//        Map<String, List> kemaoMap = new HashMap();
//        Map<String, List> kufangMap = new HashMap();
//        setDict(kemaoMap, kufangMap);
//        for (User user : users) {
//            boolean active = false;
//            if (user.getId() < 0) {
//                continue;
//            }
//
//            if ((!(user.getStatus() == null || user.getStatus().indexOf("已保留")!=-1 || user.getStatus().indexOf("已禁用")!=-1)) && (user.getCreateTag() == null ||
//                    user.getCreateTag() != 1 && user.getCreateTag() != 3) && user.getWorkNumber() != null &&
//                    LocalDateTime.now().isAfter(user.getExpectDate())) {
//                active = true;
//            }
//
//            String cell = null;
//            if (user.getCell() != null) {
//                cell = user.getCell().replaceAll(" ", "");
//            }
//
//            if (cell == null || cell.equals("") || cell.length() < 11) {
//                continue;
//            }
//
//            JSONObject didiUser = didiUsers.get(user.getWorkNumber());
//
//            List<String> carConfigList = new ArrayList<>();
//            if (user.getDidiDisabled() == null || !user.getDidiDisabled().equals(disabledCount)) {
//                carConfigList = regulationId;
//            }
//
//            List<String> kemaoRegulation = kemaoMap.get(user.getWorkNumber());
//            List<String> kufangRegulation = kufangMap.get(user.getWorkNumber());
//            if (kemaoRegulation != null) {
//                carConfigList.addAll(kemaoRegulation);
//            }
//            if (kufangRegulation != null) {
//                carConfigList.addAll(kufangRegulation);
//            }
//            carConfigList = new ArrayList<String>(new LinkedHashSet<>(carConfigList));
//            String carConfig = new String();
//            for (String s : carConfigList) {
//                carConfig = carConfig + "_" + s;
//            }
//
//            carConfig = carConfig.substring(1, carConfig.length());
//
//            if (active && didiUser == null) {
//                logger.info("active with no regulation");
//                String teamId = "";
//                if (user.getTeamId() != null) {
//                    teamId = user.getTeamId().toString();
//                }
//
//                boolean result = didiRestClient.addMember2Didi(token, teamId, user.getWorkNumber(), user.getCell(), warningUserList);
//                if (!result) {
//                    logger.info("添加滴滴用户:" + user.toString() + "失败! 手机号是:" + user.getCell());
//                }
//            } else if (!active && didiUser != null) {
//                logger.info("not active with regulation");
//                List<String> list = new ArrayList<>();
//                list.add(user.getWorkNumber());
//
//                boolean result = didiRestClient.delMember(token, list);
//                if (!result) {
//                    logger.info("删除滴滴用户" + user.toString() + "失败! ");
//                }
//            } else if (active && didiUser != null) {
//                logger.info("active with regulation");
//                String teamId = null;
//                if (user.getTeamId() != null) {
//                    teamId = user.getTeamId().toString();
//                } else {
//                    teamId = "";
//                }
//                if (need2change || !didiUser.getString("department").equals(teamId)
//                        || !didiUser.getString("use_car_config").equals(carConfig)
//                        || !didiUser.getString("phone").equals(user.getCell())) {
//
//                    boolean result = didiRestClient.editMember(token, user.getWorkNumber());
//                    if (!result) {
//                        logger.info("修改滴滴用户" + user.toString() + "失败! ");
//                    }
//                }
//            } else if (!active && didiUser == null) {
//                logger.info("not active with no regulation");
//            }
//        }
//
//        if (warningUserList.size() != 0) {
//            String content = "员工滴滴申请出错提醒-" ;
//            for (Map<String, String> map : warningUserList) {
//                content = content + "<br> 员工编号:" + map.get("workNumber") +
//                        "<br> 电话" + map.get("cell") +
//                        "<br> 工号" + map.get("workNumber") +
//                        "<br> 部门编号" + map.get("teamId") +
//                        "<br> 错误编号" + map.get("errno") +
//                        "<br> 错误信息" + map.get("errmsg") +
//                        "<br> 权限字段" + map.get("regulationId") + "<br>" ;
//            }
//            mailSendService.sendMail("员工滴滴同步出错提醒-" + DateTimeUtil.date2String(LocalDateTime.now()), content, syncMail);
//
//            return false;
//        }
//        return true;
//    }
//
//    private void setDict(Map<String, List> kemapMap, Map<String, List> kufangMap) {
//        for (String kemaoUser : kemaoUsers) {
//            kemapMap.put(kemaoUser, regulationIdKemao);
//        }
//        for (String kufangUser : kufangUsers) {
//            kufangMap.put(kufangUser, regulationIdKufang);
//        }
//    }
//
//
//}
