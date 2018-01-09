package com.mvc.common.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Contact {

    private int id;

    @NotNull
    private Date date;

    private String topic;

    private String result;
}
