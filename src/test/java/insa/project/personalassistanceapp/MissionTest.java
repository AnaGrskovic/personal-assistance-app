package insa.project.personalassistanceapp;

public class MissionTest {

    //TODO: Map form to object ? Does it work ?
    //html takes care of linking the data to the form model

    /** Test for the MissionController
     *      Check the string returned
     *
     * TODO : ShowMissionCreatingForm ? What test
     * TODO: ProcessMissionCreationForm
     * -> (Depends on createMission in the missionService)
     *      Successful, Invalid form, Invalid username
     * TODO: GetAllMissions
     * TODO: GetAllMissionsByMissionStatusName
     */

    /** Test for the userController
     *  The process methods link the html to the form model
     *
     * TODO: Show and process Professional in charge, person in need, volunteer RegistrationForm
     * TODO: ShowLoginForm
     *  to complete a form I guess ?
     *  TODO: ProcessLoginForm
     *
     */

    /** Test for the MissionService
     *      Check if the Dto returned is valid given the form
     *
     * TODO : CreateMission
     * -> Test for incorrect form
     *         * empty volunteet, empty PIN, OR both filled out
     *
     *         * if person not found (pin or volunteer)
     *         * Normal case (check they have been added to data)
     * TODO: GetAllMissions
     * -> Check that the list returned is valid
     * TODO: GetAllMissionsByMissionsStatusName
     * -> Check that the list returned is valid (Need to changes the status)
     */

    /** Test for the UserService
     *      Check if the Dto returned is valid given the form
     *
     * TODO: Registration for professional in charge, person in need, volunteer
     *  Adds it to the repository, and has a converstion to Dto through mapper
     * TODO: userLogin
     */

    //Do the mappers works ?
    //Check that the Dto fields equal those of the object

    //How are the repositories linked to the database ?
    //Do the converters work properly ?
        //Object to Dto
        //Form to Object
}
