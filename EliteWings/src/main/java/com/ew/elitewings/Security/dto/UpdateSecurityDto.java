package com.ew.elitewings.Security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSecurityDto {
    
    private Boolean isResolved; // Puede ser `true`, `false` o `null` (para no actualizarlo)
}

