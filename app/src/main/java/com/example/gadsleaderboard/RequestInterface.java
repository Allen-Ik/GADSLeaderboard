package com.example.gadsleaderboard;
import com.example.gadsleaderboard.ui.main.GADSDevelopersHoursModel;
import com.example.gadsleaderboard.ui.main.GADSDevelopersIqSkillsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RequestInterface {
    //endpoint
    @GET("/api/hours")
    Call <List<GADSDevelopersHoursModel>> getJSONHours();

    @GET("/api/skilliq")
    Call <List<GADSDevelopersIqSkillsModel>> getJSONSkillsIQ();

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")

    @FormUrlEncoded
    Call<Void> sendDetails(
            @Field("entry.1877115667") String FirstName,
            @Field("entry.2006916086") String LastName,
            @Field("entry.1824927963") String EmailAddress,
            @Field("entry.284483984") String GitHubLink
    );


}
