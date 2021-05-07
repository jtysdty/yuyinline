package com.example.server.context;

import lombok.Data;

import java.util.List;

/**
 * @描述:
 * @创建人: 曹操
 * @创建时间: 2021/4/28
 * @其它信息:
 */
@Data
public class RecodeContext extends AbstractContext implements IContext{

    private byte [] asrInputData;
    private int asrInputLen;
    private String asrResponseText;
    private int asrTextLen;

    private String nluInputText;
    private String nluDomain;
    private String nluIntent;
    private List<String> nluSlots;

    private String dmServiceName;

    private String nlgResponseText;

}
