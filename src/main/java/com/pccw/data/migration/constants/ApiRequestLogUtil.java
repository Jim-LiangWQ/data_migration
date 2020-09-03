package com.pccw.data.migration.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Alpaca 2020/01/06
 * the util of printing the specific style of log for the request API
 */
public class ApiRequestLogUtil {

    private static final Logger logger = LoggerFactory.getLogger(ApiRequestLogUtil.class);

    /**
     * Print the beginning log of the request api
     *
     * @param log
     */
    public static void beginRequestApiLog(String log) {
        logger.info("=====================API Call - {} - Start=====================", log);
    }

    /**
     * Print the response code and resultMessage
     *
     * @param code
     * @param resultMessage
     */
    public static void responseLog(String code, String resultMessage) {
        logger.info("Response to Client: resultCode={};internal={}", code, resultMessage);
    }

    /**
     * Print the response code and resultMessage
     *
     * @param clazz
     * @param code
     * @param resultMessage
     */
    public static void responseLog(Class<?> clazz, String code, String resultMessage) {
        LoggerFactory.getLogger(clazz).info("Response to Client: resultCode={};internal={}", code, resultMessage);
    }

    /**
     * Print the beginning log of the request api
     *
     * @param clazz
     * @param log
     */
    public static void beginRequestApiLog(Class<?> clazz, String log) {
        LoggerFactory.getLogger(clazz).info("=====================API Call - {} - Start=====================", log);
    }

    /**
     * Print the ending log of the request api
     *
     * @param log
     */
    public static void endRequestApiLog(String log) {
        logger.info("=====================API Call - {} - End=====================", log);
    }

    /**
     * Print the ending log of the request api
     *
     * @param clazz
     * @param log
     */
    public static void endRequestApiLog(Class<?> clazz, String log) {
        LoggerFactory.getLogger(clazz).info("=====================API Call - {} - End=====================", log);
    }

    /**
     * Print the response code and resultMessage
     *
     * @param baseResponse
     */
    public static void responseLog(Object baseResponse) {
        if (null != baseResponse) {
            logger.info("Response to Client:{}", baseResponse.toString());
        }
    }

    /**
     * Print the response code and resultMessage
     *
     * @param clazz
     * @param baseResponse
     */
    public static void responseLog(Class<?> clazz, Object baseResponse) {
        if (null != baseResponse) {
            LoggerFactory.getLogger(clazz).info("Response to Client:{}", baseResponse.toString());
        }
    }

    public static void log(Object logMessage) {
        if (null != logMessage) {
            logger.info(logMessage.toString());
        }
    }
}
