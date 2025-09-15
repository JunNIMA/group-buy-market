package cn.bugstack.api.dto;


import lombok.Data;

@Data
public class RefundMarketPayOrderRequestDTO {

    /** 渠道 */
    private String source;
    /** 来源 */
    private String channel;
    /** 用户ID */
    private String userId;
    /** 外部交易单号 */
    private String outTradeNo;
}
