package com.projectSE.credentialMicroservices.services;

public interface RegistrationService {

    boolean controlPatternPassword(String password);

    void saveUser(String name, String surname, String email, String password, int type, int id_course_of_study);

    String createEmail(String name, String surname);

}
