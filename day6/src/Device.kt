class Device(bufferStream: String) {
    val messageMarkerPosition = (14..bufferStream.length).first {
        bufferStream.substring((it - 14) until it).toList().distinct().size == 14
    }
    val packetMarkerPosition = (4..bufferStream.length).first {
        bufferStream.substring((it - 4) until it).toList().distinct().size == 4
    }
}