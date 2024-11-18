package com.github.logkt

import kotlinx.coroutines.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

class Logger(val name: String, var level: Level = Level.ERROR) {
    private var job: Job? = null
    private val scope = CoroutineScope(Dispatchers.Default)

    private val records: BlockingQueue<LogRecord> = LinkedBlockingQueue()
    private val out = System.out.bufferedWriter(Charsets.UTF_8)

    fun open() { job = scope.launch { run() } }

    private fun run(): Job {
        return scope.launch {
            while (isActive) {
                try {
                    val record = records.take()
                    if (level == Level.OFF) return@launch

                    if (level.ordinal >= record.level.ordinal) {
                        // write into out
                    }
                } catch (error: Exception) {
                    // handle errors
                    close()
                }
            }
        }
    }

    fun close() {
        job?.cancel()
    }
}