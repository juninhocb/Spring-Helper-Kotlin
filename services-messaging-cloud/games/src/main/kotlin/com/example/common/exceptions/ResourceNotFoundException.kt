package com.example.common.exceptions

class ResourceNotFoundException(id: String) : RuntimeException("The resource $id was not found") {
}