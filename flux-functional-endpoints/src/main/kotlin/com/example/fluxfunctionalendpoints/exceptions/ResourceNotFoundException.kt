package com.example.fluxfunctionalendpoints.exceptions

class ResourceNotFoundException(id: Long) : RuntimeException("Resource was not found $id"){
}