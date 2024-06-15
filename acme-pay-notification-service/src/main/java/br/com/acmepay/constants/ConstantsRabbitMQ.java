package br.com.acmepay.constants;

public class ConstantsRabbitMQ {
    public static final String EXCHANGE_CHECK_DOCUMENT = "check_document_queue_exchange";
    public static final String EXCHANGE_CHECK_DOCUMENT_SUCCESS = "check_document_success_queue_exchange";
    public static final String EXCHANGE_CHECK_DOCUMENT_FAIL = "check_document_fail_queue_exchange";

    public static final String QUEUE_CHECK_DOCUMENT = "queue_check_document";
    public static final String QUEUE_CHECK_DOCUMENT_SUCCESS = "queue_check_document_success";
    public static final String QUEUE_CHECK_DOCUMENT_FAIL = "queue_check_document_fail";

}
