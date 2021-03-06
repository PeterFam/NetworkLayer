package com.starwallet.networklayer.data.remote

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific failure should extend [FeatureFailure] class.
 */
sealed class Failure {

    object NetworkConnection: Failure()
    object ServerError: Failure()
    object Unauthorizes: Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure: Failure()
}