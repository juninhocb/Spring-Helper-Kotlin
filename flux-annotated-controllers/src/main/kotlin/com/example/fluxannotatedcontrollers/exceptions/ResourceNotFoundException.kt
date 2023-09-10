package com.example.fluxannotatedcontrollers.exceptions

class ResourceNotFoundException(id: String) : RuntimeException("Not found id $id") {
}