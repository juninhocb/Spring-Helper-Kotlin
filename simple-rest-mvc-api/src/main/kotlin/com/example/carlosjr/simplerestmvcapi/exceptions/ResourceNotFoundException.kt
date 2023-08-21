package com.example.carlosjr.simplerestmvcapi.exceptions

class ResourceNotFoundException(msg: String) : RuntimeException("This resource $msg was not found") {
}