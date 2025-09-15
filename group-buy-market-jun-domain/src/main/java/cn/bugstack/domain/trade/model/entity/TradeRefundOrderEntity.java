package cn.bugstack.domain.trade.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 交易退单实体对象
 *
 * @author xiaofuge bugstack.cn @小傅哥
 * 2025/7/11 19:45
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeRefundOrderEntity {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 拼单组队ID
     */
    private String teamId;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 预购订单ID
     */
    private String orderId;

    /**
     * 单号
     */
    private String outTradeNo;
}
