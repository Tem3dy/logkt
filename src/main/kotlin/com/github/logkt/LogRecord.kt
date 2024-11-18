package com.github.logkt

import java.time.Instant

data class LogRecord(
    val date: Instant,
    val level: Level,
    val text: String,
    val error: Throwable? = null,
    val thread: Thread = Thread.currentThread()
)