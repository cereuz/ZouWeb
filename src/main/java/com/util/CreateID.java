package com.util;

import java.util.Random;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/4/18 10:36.
 * @motto : To be, or not to be.
 */
public class CreateID {
    public static String returnCard(){
        String cardNnumer=getCard();//调用生成随机数的方法：这里以6位为例
        Boolean eCard = DBUtils.selectByCardNum(Constants.SQL_SELECT_UBER_UDID,cardNnumer);//生成的随机数进入数据库中查询一下，看时候有相同的。
        if(eCard != false){//如果有相同的数据
            return returnCard();//再次调用方法，生成一个随机数
        }else{//否则
            return cardNnumer;//这个数据我就要
        }
    }
    //生成随机数
    public static String getCard(){
        Random rand=new Random();//生成随机数
        String cardNnumer= "";
        cardNnumer += rand.nextInt(9) + 1;
        for(int a=1;a<6;a++){
            cardNnumer+=rand.nextInt(10);//生成6位数字
        }
        return cardNnumer;
    }
}
