package com.jyh.jiangboot.command;

import java.io.UnsupportedEncodingException;

public class TestString {


    public static void main(String[] args) throws UnsupportedEncodingException {
        String temp = "姜宇鸿";

        String temp2 = temp.trim().toLowerCase();

        System.out.println(temp2);




//        StringBuilder msg = new StringBuilder();

//        for (int i = 0; i < 5; i ++) {
//
//            msg.append("111");
//        }

//        String a = "\u4dae";
//        String b = "\ue863";
//
//
//
//
//        System.out.println(new String(b.getBytes("utf-8")));
//
//        System.out.println(new String(a.getBytes("utf-8")));


//        a.ch









//        String aaa = "???????????";
//        String bbb = "???";
//
//        if(aaa.indexOf(bbb)!=-1){
//            System.out.println("??");
//        }else{
//            System.out.println("???");
//        }
//
//        int total = 1820;
//        int group = 70;
//        int a = total / group ;
//        int b = total % group;
//        System.out.println(a);
//        System.out.println(b);
//        if (total % group != 0) {
//            System.out.println("1");
//        }


//        SingleDemo.getIntstance();
//        SingleDemo.show();



//        String qqq = "qqq-www-eee-rrr";
//        String[] www = qqq.split("-");
//        if (www.length > 4) {
//            String ccc = www[4];
//            System.out.println(ccc);
//        }
//
//        int fff = 1;
//        fff += 1;
//        System.out.println(fff);

//        System.out.println(UUID.randomUUID().toString().length());
//
//        String team = "????????-??????????-???";
//        String[] teamNames = team.split("-");
//
//        System.out.println(teamNames.length);
//
//        System.out.println(teamNames[0]);
//        System.out.println(teamNames[1]);
//        System.out.println(teamNames[2]);
//        System.out.println(teamNames[3]);


//        String parentName = team.replaceAll("-" + teamNames[teamNames.length - 1], "");
//
//        System.out.println(1);

//        String[] teams = team.split("-");
//
//        String spell = "JYH";
//        spell = spell + "-" + teams[teams.length - 1];
//        System.out.println(spell);
//
//        String a = "jiangyuhong@megvii.com";
//        String b = a.split("@")[0];
//        System.out.println(b);




//        String a = "???";
//        System.out.println(gbEncoding(a));
//        System.out.println(decodeUnicode(gbEncoding(a)));
//
//
//        Attributes attributes=new BasicAttributes() ;
//        BasicAttribute objectclass=new BasicAttribute("objectclass");
//        objectclass.add("top");
//        objectclass.add("person");
//        objectclass.add("organizationalPerson");
//        objectclass.add("user");
//
//        attributes.put(objectclass);
//        attributes.put("cn",1);
//        attributes.put("sAMAccountname",2);
//
//        System.out.println(attributes);

    }



    /**
     * ???UNICODE
     * @param gbString
     * @return
     */
    public static String gbEncoding(final String gbString) {
        char[] utfBytes = gbString.toCharArray();
        String unicodeBytes = "";
        for (int i = 0; i < utfBytes.length; i++) {
            String hexB = Integer.toHexString(utfBytes[i]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        return unicodeBytes;
    }


    /**
     * UNICODE???
     * @param dataStr
     * @return
     */
    public static String decodeUnicode(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16??parse??????
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }



}
