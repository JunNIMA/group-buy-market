package cn.bugstack.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RefundMarketPayOrderResponseDTO {

    /** 用户ID */
    private String userId;
    /** 拼单组队ID */
    private String teamId;
    /** 单号ID */
    private String orderId;

    private String code;

    private String info;
}
