package com.trongphu.ticketmovie.dto.respone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Trong Phu on 6/2/2024 23:02:22
 *
 * @author Trong Phu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResDTO  implements Serializable {

    private String status;
    private String message;
    private String URL;
}
