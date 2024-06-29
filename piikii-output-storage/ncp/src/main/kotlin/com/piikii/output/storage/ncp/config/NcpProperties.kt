package com.piikii.output.storage.ncp.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "ncp")
data class NcpProperties(
    val key: KeyProperties,
    val bucket: BucketProperties,
) {
    data class KeyProperties(
        val access: String,
        val secret: String,
    )

    data class BucketProperties(
        val name: String,
        val folder: FolderProperties,
    ) {
        data class FolderProperties(
            val name: NameProperties,
        ) {
            data class NameProperties(
                val placeFolder: String,
                val roomFolder: String,
            )
        }
    }
}
