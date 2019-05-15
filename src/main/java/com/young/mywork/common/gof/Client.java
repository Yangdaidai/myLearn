package com.young.mywork.common.gof;

import com.young.mywork.common.gof.inter.PayStrategy;

/**
 * Author 10248
 * Date 2019/5/14 21:07
 * Description
 */
public class Client {
    public static void main(String[] args) throws Exception {

        /**
         * 总结
         * if…else if…的缺点
         *
         *     多分支和复杂度高的逻辑会使代码冗长，难以理解和维护。
         *     违反开闭原则，增删分支需要改动if…else if结构，，增大代码出错风险
         *
         * 使用策略模式+工厂模式的优点
         *
         *     对应的分支处理分成不同策略类来实现，使代码易于读懂和维护
         *     扩展性好，增加分支只需要增加对应的策略实现类和枚举。符合开闭原则
         *  缺点:
         *      增加了多余的类
         */

        String payStrategyParam = "ALIPAY";//Param from front end
        PayStrategy strategy = StrategyFactory.getStrategy(payStrategyParam);
        strategy.pay(12);

        payStrategyParam = "WECHATPAY";//Param from front end
        strategy = StrategyFactory.getStrategy(payStrategyParam);
        strategy.pay(12);

    }
}
