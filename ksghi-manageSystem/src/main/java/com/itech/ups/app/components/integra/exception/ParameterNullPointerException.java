package com.itech.ups.app.components.integra.exception;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2014-3-31
 * @author  zqs
 * ===========================================================================
 *
 */

public class ParameterNullPointerException extends IntegraRuntimeException {

    private static final long serialVersionUID = -6468505915271394854L;

    public ParameterNullPointerException(String paramName) {
        super("参数" + paramName + "不能为空！");
    }
}