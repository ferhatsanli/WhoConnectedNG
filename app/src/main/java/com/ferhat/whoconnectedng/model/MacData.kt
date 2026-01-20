package com.ferhat.whoconnectedng.model

import com.google.gson.annotations.SerializedName

data class MacData(
    val data: MacInfo
)

data class MacInfo(
    val registry: String,
    val assignment: String,
    @SerializedName("organization_address")
    val organizationAddress: String,
    @SerializedName("organization_name")
    val organizationName: String
)
