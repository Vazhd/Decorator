//1)
public class First {
    public static void main(String[] args) {
        IDeveloper developer = new ITTeamLead(new SeniorITDeveloper(new ITDeveloper()));
        System.out.println(developer.makeJob());


    }
}
interface IDeveloper{
    public String makeJob();
}
class ITDeveloper implements IDeveloper{
    @Override
    public String makeJob() {
        return "Write code";
    }
}
class DeveloperDecorator implements IDeveloper{
    IDeveloper developer;

    public DeveloperDecorator(IDeveloper developer){
        this.developer = developer;
    }

    @Override
    public String makeJob() {
        return developer.makeJob();
    }
}

class SeniorITDeveloper extends DeveloperDecorator{
    public SeniorITDeveloper(IDeveloper developer) {
        super(developer);
        }
        public String makeCodeReview(){
        return " Make code review";
        }

    @Override
    public String makeJob() {
        return super.makeJob() + makeCodeReview();
    }
}

class ITTeamLead extends DeveloperDecorator{

    public ITTeamLead(IDeveloper developer) {
        super(developer);
    }
    public String sendWeekReport(){
        return " Send Week report";

    }

    @Override
    public String makeJob() {
        return super.makeJob() + sendWeekReport();
    }
}
