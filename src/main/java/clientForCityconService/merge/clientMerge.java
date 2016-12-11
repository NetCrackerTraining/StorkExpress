package clientForCityconService.merge;

import clientForCityconService.GetAllUsers;
import clientForCityconService.GetAllUsersServiceLocator;
import clientForCityconService.User;

import java.util.ArrayList;
import java.util.List;

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

            ArrayList<String> cityconLog = new ArrayList();
            ArrayList<String> cityconPass = new ArrayList();
            ArrayList<String> cityconEmail = new ArrayList();
            for(int i=0;i<allUsers.length;i++) {
                cityconLog.add(allUsers[i].getLogin().toLowerCase()) ;
                cityconPass.add(allUsers[i].getPassword());
                cityconEmail.add(allUsers[i].getEmail().toLowerCase());
            }
            ArrayList<String> oldLog = merge.getOldUsers("username");
            ArrayList<String> oldEmail = merge.getOldUsers("email");

            List<String> cL = new ArrayList<>(cityconLog);
            cL.removeAll(oldLog);

            ArrayList<Integer> index = new ArrayList<>();

            for (int i =0;i<cL.size();i++) {
                String s = cL.get(i);
                index.add(cityconLog.indexOf(s));
            }

            ArrayList<String> cityconLog1 = new ArrayList();
            ArrayList<String> cityconPass1 = new ArrayList();
            ArrayList<String> cityconEmail1 = new ArrayList();

            for (int i = 0;i<index.size();i++) {
                cityconLog1.add(cityconLog.get(index.get(i)));
                cityconEmail1.add(cityconEmail.get(index.get(i)));
                cityconPass1.add(cityconPass.get(index.get(i)));
            }

            List<String> cE = new ArrayList<>(cityconEmail1);
            cE.removeAll(oldEmail);

            ArrayList<Integer> index1 = new ArrayList<>();

            for (int i =0;i<cE.size();i++) {
                String s = cE.get(i);
                index1.add(cityconEmail1.indexOf(s));
            }

            ArrayList<String> cityconLog2 = new ArrayList();
            ArrayList<String> cityconPass2 = new ArrayList();
            ArrayList<String> cityconEmail2 = new ArrayList();

            for (int i = 0;i<index1.size();i++) {
                cityconLog2.add(cityconLog1.get(index1.get(i)));
                cityconEmail2.add(cityconEmail1.get(index1.get(i)));
                cityconPass2.add(cityconPass1.get(index1.get(i)));
            }

            for (int i=0;i<cityconLog2.size();i++){
                merge.addInUsers(cityconLog2.get(i),cityconPass2.get(i),cityconEmail2.get(i));
            }

        }
        catch (javax.xml.rpc.ServiceException ex){
            ex.printStackTrace();
        }
        catch (java.rmi.RemoteException ex){
            ex.printStackTrace();
        }
    }
}
