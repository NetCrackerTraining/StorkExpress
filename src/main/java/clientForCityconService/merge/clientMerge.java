package clientForCityconService.merge;

import clientForCityconService.GetAllUsers;
import clientForCityconService.GetAllUsersServiceLocator;
import clientForCityconService.User;

/**
 * Created by Vlad on 11.12.2016.
 */
public class clientMerge {
    public static void mergeStart() {
        try{
            GetAllUsersServiceLocator locator = new GetAllUsersServiceLocator();
            GetAllUsers service = locator.getGetAllUsersPort();
            User[] allUsers = service.getUsers();

            clientDAO merge = new clientDAO();

            String[] cityconLog = new String[allUsers.length];
            String[] cityconPass = new String[allUsers.length];
            String[] cityconEmail = new String[allUsers.length];
            for(int i=0;i<allUsers.length;i++) {
                cityconLog[i] = allUsers[i].getLogin();
                cityconPass[i] = allUsers[i].getPassword();
                cityconEmail[i] = allUsers[i].getEmail();
            }


            for (int i=0;i<allUsers.length;i++){
                merge.addInSource(cityconLog[i],cityconPass[i],cityconEmail[i]);
                System.out.print(cityconLog[i]+" "+cityconPass[i]+" "+cityconEmail[i]+"\n");
            }
            merge.mergeWithTable();
            merge.deleteSource();
        }
        catch (javax.xml.rpc.ServiceException ex){
            ex.printStackTrace();
        }
        catch (java.rmi.RemoteException ex){
            ex.printStackTrace();
        }
    }
}
