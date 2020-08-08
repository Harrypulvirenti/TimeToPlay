package com.ttp.feature.home.extensions

import android.net.Uri
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory

private const val USER_AGENT = "ttp-user-agent"

internal fun ExoPlayer.play() = play(true)

internal fun ExoPlayer.pause() = play(false)

internal fun ExoPlayer.play(play: Boolean) {
    playWhenReady = play
}

internal fun String.toMediaSource(): MediaSource =
    ExtractorMediaSource.Factory(DefaultHttpDataSourceFactory(USER_AGENT))
        .createMediaSource(Uri.parse(this))
