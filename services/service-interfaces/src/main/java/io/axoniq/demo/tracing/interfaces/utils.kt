/*
 * Copyright (c) 2023-2023. AxonIQ
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.axoniq.demo.tracing.interfaces

import org.slf4j.LoggerFactory
import reactor.core.Disposable
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers
import java.util.concurrent.TimeUnit


private val logger = LoggerFactory.getLogger("DemoTaskScheduler")

fun runTask(scheduler: Scheduler, delayInMs: Long, block: () -> Unit): Disposable {
    return scheduler.schedule({
        try {
            block.invoke()
        } catch (e: Exception) {
            logger.error("Error", e)
        }
    }, delayInMs, TimeUnit.MILLISECONDS)
}
