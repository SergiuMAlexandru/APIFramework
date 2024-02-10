package Service.ServiceImplementation;

import EndPoints.AccountEndPoints;
import Objects.RequestObject.RequestAccount;
import Objects.RequestObject.RequestAccountToken;
import Service.APIService.AccountAPIService;
import Service.InterfaceService.AccountServiceInterface;
import io.restassured.response.Response;

public class AccountServiceImplementation implements AccountServiceInterface {

    //dupa ce am definit AccountEndPoints am venit aici sa completam

    public AccountAPIService accountAPIService;
    @Override
    public Response createAccount(RequestAccount requestAccount) {
        accountAPIService = new AccountAPIService();
        return accountAPIService.post(requestAccount, AccountEndPoints.ACCOUNT_CREATE);
    }

    @Override
    public Response generateToken(RequestAccountToken requestAccountToken) {
        accountAPIService = new AccountAPIService();
        return accountAPIService.post(requestAccountToken, AccountEndPoints.ACCOUNT_TOKEN);
    }

    @Override
    public Response getSpecificAccount(String userID, String token) {
        accountAPIService = new AccountAPIService();
        String finalEndpoint = AccountEndPoints.ACCOUNT_SPECIFIC.replace("{userID}", userID); //face replace la endpoinul din AccountEndPoints
        return accountAPIService.get(finalEndpoint, token);

    }

    @Override
    public Response deleteSpecificUser(String userID, String token) {
        accountAPIService = new AccountAPIService();
        String finalEndpoint = AccountEndPoints.ACCOUNT_DELETE.replace("{userID}", userID);
        return accountAPIService.delete(finalEndpoint, token);
    }
}
