package com.example.carlosjr.simplemvcrestrelationship.exceptions

class ResourceNotFoundException(idResource: String) : RuntimeException("The resource $idResource was not found") {
}