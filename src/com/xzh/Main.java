package com.xzh;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<declareSub3Entity> list3 = new ArrayList<declareSub3Entity>();
        List<declareSub3Entity> newList3 = new ArrayList<declareSub3Entity>();
        List<declareSub5Entity> list5 = new ArrayList<declareSub5Entity>();
        List<declareSub5Entity> newList5s = new ArrayList<declareSub5Entity>();
        list5.add(new declareSub5Entity("直接经费","材料及燃料、动力费","材料零用费","12"));
        list5.add(new declareSub5Entity("直接经费","材料及燃料、动力费","材料外购费","12"));
        list5.add(new declareSub5Entity("直接经费","材料及燃料、动力费","燃料动力费","12"));
        list5.add(new declareSub5Entity("间接经费","其它1","间接经费1","12"));
        list5.add(new declareSub5Entity("间接经费","其它2","材料零用费2","12"));

        list5.add(new declareSub5Entity("直接经费","材料及燃料、动力费","材料外购费","13"));
        list5.add(new declareSub5Entity("直接经费","材料费","","13"));
        list5.add(new declareSub5Entity("间接经费","其它1","间接经费1","13"));
        list5.add(new declareSub5Entity("间接经费","其它2","材料零用费2","13"));

        list5.add(new declareSub5Entity("直接经费","设备费","","14"));
        list5.add(new declareSub5Entity("直接经费","材料及燃料、动力费","燃料动力费","14"));
        list5.add(new declareSub5Entity("间接经费","其它3","间接经费1","12"));
        list5.add(new declareSub5Entity("间接经费","其它4","材料零用费2","12"));

        //按照type分类
        Map<String , List<declareSub5Entity>> map = new HashMap<>();
        for (int i = 0; i < list5.size(); i++) {
            List<declareSub5Entity> newList5 = map.get(list5.get(i).getType());
            if(null!=newList5){
                newList5.add(list5.get(i));
            }else{
                List<declareSub5Entity> list = new ArrayList<declareSub5Entity>();
                list.add(list5.get(i));
                map.put(list5.get(i).getType(),list);
            }
        }
        List<declareSub5Entity> zjjfs = map.get("直接经费");
        declareSub5Entity zjjf = new declareSub5Entity();
        zjjf.setSubject("直接经费");
        Integer zjjfys = 0;//直接经费预算
        //一级科目由报表工具合并,所以只需要合并二级科目
        Map<String , declareSub5Entity> twoMap = new HashMap<>();
        List<declareSub5Entity> list5s = new ArrayList<declareSub5Entity>();
        Set<String> twoSet = new HashSet<String>();
        for (int j = 0; j < zjjfs.size(); j++) {
            if(zjjfs.get(j).getTwoSubject()!=""){
                twoSet.add(zjjfs.get(j).getTwoSubject());
                declareSub5Entity declareSub5 = twoMap.get(zjjfs.get(j).getTwoSubject());
                if(null!=declareSub5){
                    Integer totelYs = Integer.parseInt(declareSub5.getTotleYS())+Integer.parseInt(zjjfs.get(j).getTotleYS());
                    declareSub5.setTotleYS(totelYs.toString());
                }else{
                    twoMap.put(zjjfs.get(j).getTwoSubject(),zjjfs.get(j));
                }
            }else{
                list5s.add(zjjfs.get(j));
            }
            zjjfys += Integer.parseInt(zjjfs.get(j).getTotleYS());
        }
        zjjf.setTotleYS(zjjfys.toString());
        newList5s.add(zjjf);
        newList5s.addAll(list5s);
        for (String twoSubject:twoSet) {
            newList5s.add(twoMap.get(twoSubject));
        }

        List<declareSub5Entity> jjjfs = map.get("间接经费");
        declareSub5Entity jjjf = new declareSub5Entity();
        jjjf.setSubject("间接经费");
        Integer jjjfys = 0;//间接经费预算
        //一级科目由报表工具合并,所以只需要合并二级科目
        twoMap = new HashMap<>();
        list5s = new ArrayList<declareSub5Entity>();
        twoSet = new HashSet<String>();
        for (int j = 0; j < jjjfs.size(); j++) {
            if(jjjfs.get(j).getTwoSubject()!=""){
                twoSet.add(jjjfs.get(j).getTwoSubject());
                declareSub5Entity declareSub5 = twoMap.get(jjjfs.get(j).getTwoSubject());
                if(null!=declareSub5){
                    Integer totelYs = Integer.parseInt(declareSub5.getTotleYS())+Integer.parseInt(jjjfs.get(j).getTotleYS());
                    declareSub5.setTotleYS(totelYs.toString());
                }else{
                    twoMap.put(jjjfs.get(j).getTwoSubject(),jjjfs.get(j));
                }
            }else{
                list5s.add(zjjfs.get(j));
            }
            jjjfys += Integer.parseInt(jjjfs.get(j).getTotleYS());
        }
        jjjf.setTotleYS(jjjfys.toString());
        newList5s.add(jjjf);
        newList5s.addAll(list5s);
        for (String twoSubject:twoSet) {
            newList5s.add(twoMap.get(twoSubject));
        }

        Map<String,declareSub5Entity> oneMap = new HashMap<>();
        Set<String> oneSet = new HashSet<String>();
        for (int k = 0; k < newList5s.size(); k++) {
            oneSet.add(newList5s.get(k).getSubject());
            declareSub5Entity oneSub5 = oneMap.get(newList5s.get(k).getSubject());
            if(null != oneSub5){
                Integer totelYs = Integer.parseInt(oneSub5.getTotleYS())+Integer.parseInt(newList5s.get(k).getTotleYS());
                oneSub5.setTotleYS(totelYs.toString());
            }else {
                oneMap.put(newList5s.get(k).getSubject(),newList5s.get(k));
            }
        }
        String str = "";
        for (String oneSubject:oneSet) {
            str+="&nbsp;";
            oneMap.get(oneSubject).setTotleYS(oneMap.get(oneSubject).getTotleYS()+str);
        }

        for (int p = 0; p < newList5s.size(); p++) {
            newList5s.get(p).setTotleYS(oneMap.get(newList5s.get(p).getSubject()).getTotleYS());
        }


        list3.add(new declareSub3Entity("2020","总部处室列支经费","12",list5));
        list3.add(new declareSub3Entity("2021","总部处室列支经费","13",list5));
        list3.add(new declareSub3Entity("2022","总部处室列支经费","14",list5));

        //处理数据
        declareSub3Entity declareSub3 = new declareSub3Entity();
        declareSub3.setYear(list3.get(0).getSubject());
        Integer jf = 0;
        for (int i = 0; i < list3.size(); i++) {
            if(i==0){
                list3.get(i).setYear("其中"+list3.get(i).getYear()+"年");
            }else{
                list3.get(i).setYear(list3.get(i).getYear()+"年");
            }
            jf+=Integer.parseInt(list3.get(i).getTotleYS());
        }
        declareSub3.setTotleYS(jf.toString());
        newList3.add(declareSub3);
        newList3.addAll(list3);

        //处理支出费用数据
        //1、先根据类型（直接、间接）分类
        //2、

        System.err.printf("test");
    }
}
