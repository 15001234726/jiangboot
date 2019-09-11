package com.jyh.jiangboot.command;

public class TestString {


    public static void main(String[] args) {

//        String aaa = "淘鲜达啦啦啦啦略略略略";
//        String bbb = "淘鲜达";
//
//        if(aaa.indexOf(bbb)!=-1){
//            System.out.println("包含");
//        }else{
//            System.out.println("不包含");
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
        String team = "金融科技业务团队-互联网金融流量业务部-运营组";
        String[] teamNames = team.split("-");

        String parentName = team.replaceAll("-" + teamNames[teamNames.length - 1], "");

        System.out.println(1);

//        String[] teams = team.split("-");
//
//        String spell = "JYH";
//        spell = spell + "-" + teams[teams.length - 1];
//        System.out.println(spell);
//
//        String a = "jiangyuhong@megvii.com";
//        String b = a.split("@")[0];
//        System.out.println(b);




//        String a = "姜宇鸿";
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
     * 中文转UNICODE
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
     * UNICODE转中文
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
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }



}
