package com.example.medicare.profile;

import com.example.medicare.profile.model.Profile;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterfaceProfile {



//    @Headers("Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNTI2Yzk1YTBlNzdlMTYyNTUwZGViZjAzYWMwOTQzYmI1ODIxNzE3Nzg4ZGIyMWUxYjYyMDY0MjEwMjg3Y2NlMzIwMWE5MDczYzE2MjFkNWIiLCJpYXQiOjE2NDE2Njc0MTYsIm5iZiI6MTY0MTY2NzQxNiwiZXhwIjoxNjczMjAzNDE2LCJzdWIiOiI3Iiwic2NvcGVzIjpbXX0.QUT4AG4Tw4SwQaVJ3kzp05bj6Z8TiGuRh-vGJF77hMhD-FdBOgzp_un6zBcGXqMkMfR2cOtcFrw9pcpB6YxDTBQ19oOYCp2Z4Z8U3J96qUlcln2WHSyTvphfaOzN95QBzBn6lsfxedtVRCdHNTQI3PMGyfrb7t1kgrrEaw1oZCMD_EfX3AGIB8lbgM1woitXjtK2U3BX2Q27UMI7U4v2M6aqkR0JZAum37wvMzXz7pJ2GEmn1DNqNi_NAu2Wwlade3hYV0QM9Iifw_fUZjPF2w5O8UvsY_WsGlwi2q6F73VQjbKLE1NWc1vUuluY-85Wt-1RROsBVBCNdqEfCRzcBt75PIYxNVwKM4VlmmdpxLiSPRnLi_BXpVYGSzfWjHVgD09HXICsK1tzQG5kV5rkZyiyf3n1ehThhmiAlVWJ9qC30glzhqAMQkoXPCPfJVlXe6f4-NgX6sLmvUoCdZxvuBHrG4pVIsjAitatNOt882QdGwuUILqxpvhny9ZqVEKe7I8uEYtqiFh-kOPExe_bQY94uBzdnTwpkDSh2gU0pVBvM4yPa4uAffz68qtLk2G08MlVkwq8ShbdLmD5tQnkQB-OSMT6dCtT2u4_HDc--uI-SXOGtOXxC5yLTRz0rIGRntGM9pLy71we-lmcxdOaZ4ahAo3Q06kSmtFNQKCq4vA")

    @FormUrlEncoded
    @POST("updateprofile")
    Call<Profile> updateProfileResponse(

            @Header("Authorization") String auth,
            @Field("name") String name,
            @Field("email") String email,
            @Field("phone") String phone,
            @Field("password") String password,
            @Field("tanggallahir") String tanggallahir,
            @Field("tinggi") Integer tinggi,
            @Field("berat") Integer berat,
            @Field("jeniskelamin") String jeniskelamin,
            @Field("profile_picture") String profile_picture

    );

    @POST("getprofile")
    Call<Profile> getProfile(
            @Header("Authorization") String auth
    );
}
