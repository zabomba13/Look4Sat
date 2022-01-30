package com.rtbishop.look4sat.framework.remote

import com.rtbishop.look4sat.data.IRemoteSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.net.URL

class RemoteSource(private val ioDispatcher: CoroutineDispatcher) : IRemoteSource {

    @Suppress("BlockingMethodInNonBlockingContext")
    override suspend fun fetchFileStream(url: String): InputStream? {
        return withContext(ioDispatcher) { URL(url).openStream() }
    }
}
