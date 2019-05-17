package com.young.mywork.common.gof.strategy;

import com.young.mywork.common.gof.inter.PayStrategy;

/**
 * Author 10248
 * Date 2019/5/14 21:05
 * Description
 */
public class StrategyFactory {

    public static PayStrategy getStrategy(String strategyType) throws Exception {
        String className = PayEnum.valueOf(strategyType).getClassName();
        return (PayStrategy) Class.forName(className).newInstance();
    }

}
