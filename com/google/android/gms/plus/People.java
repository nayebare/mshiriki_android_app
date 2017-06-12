package com.google.android.gms.plus;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.plus.model.people.Person;
import java.util.Collection;

@Deprecated
public interface People {
    @Deprecated
    Person getCurrentPerson(GoogleApiClient googleApiClient);

    @Deprecated
    PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, Collection<String> collection);

    @Deprecated
    PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, String... strArr);

    @Deprecated
    PendingResult<LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient);

    @Deprecated
    PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, int i, String str);

    @Deprecated
    PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, String str);
}
