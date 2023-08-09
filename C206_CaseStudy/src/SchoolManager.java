public class SchoolManager extends ManageSch {

    private Admin admin;

    public SchoolManager(Admin admin) {
        this.admin = admin;
    }

    @Override
    public void addSchool(String name, String address) {
        if (this.admin.authentication("admin", "password")) {
            super.addSchool(name, address);
        } else {
            System.out.println("You are not authorized to add schools");
        }
    }

    @Override
    public void viewAllSchools() {
        if (this.admin.authentication("admin", "password")) {
            super.viewAllSchools();
        } else {
            System.out.println("You are not authorized to view schools");
        }
    }

    @Override
    public void deleteSchool(String name) {
        if (this.admin.authentication("admin", "password")) {
            super.deleteSchool(name);
        } else {
            System.out.println("You are not authorized to delete schools");
        }
    }
}