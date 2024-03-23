package com.hddev.meditationpal.model

import java.time.Instant
import java.util.Date

data class MeditationSession(
    val id: String,
    val startTime: Instant,
    val endTime: Instant,
    val note: String
)