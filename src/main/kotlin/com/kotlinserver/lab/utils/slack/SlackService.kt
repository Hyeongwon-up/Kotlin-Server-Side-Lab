package com.kotlinserver.lab.utils.slack

import com.slack.api.Slack
import com.slack.api.webhook.Payload
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.AsyncResult
import org.springframework.stereotype.Service
import java.util.concurrent.Future

@Service
@Async("taskExecutor")
class SlackService {

    @Value("\${slack.webhook-url.info}")
    private lateinit var SLACK_WEBHOOK_URL_INFO: String

    fun sendMessage(message: String): Future<Boolean> {

        val slack: Slack = Slack.getInstance()
        val webHookUrl = SLACK_WEBHOOK_URL_INFO
        val text = message
        val payload = Payload.builder().text(text).build()
        val response = slack.send(webHookUrl, payload)

        return AsyncResult(response.code == 200)
    }

//    fun sendMessage2(fieldMap: Map<String, String>, messageLevel: slackMessageLevel): Future<Boolean> {
//
//        val slack: Slack = Slack.getInstance()
//        val webHookUrl = when (messageLevel) {
//            slackMessageLevel.INFO -> SLACK_WEBHOOK_URL_INFO
//        }
//
//        val text = StringBuilder().apply {
//            fieldMap.forEach {
//                if (it.value != null) {
//                    append("*${it.key}*")
//                    append("\n    ${it.value}\n\n")
//                }
//            }
//        }.toString()
//        val payload = Payload.builder().text(text).build()
//        val response = slack.send(webHookUrl, payload)
//
//        return AsyncResult(response.code == 200)
//    }
}