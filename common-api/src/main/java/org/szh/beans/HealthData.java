package org.szh.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class HealthData implements Serializable{
	
    /** */
	private static final long serialVersionUID = 5295341156434359211L;

	private String markId;

    private String name;

    private BigDecimal weight;

    private BigDecimal height;

}