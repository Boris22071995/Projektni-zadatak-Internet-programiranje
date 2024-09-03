package org.unibl.program.Entity.Requests;

import javax.validation.constraints.NotBlank;

public class PincodeRequest {
    @NotBlank
    private Integer pinCode;

    public Integer getPinCode() {
        return pinCode;
    }
}
