public class LinkedDome {
    public static void main(String[] args) {
        BoyGame boyGame = new BoyGame();
        boyGame.addBoy(7);
        boyGame.show();

    }
}
class Boy{
    public int  boyno;
    public Boy next=null;
    protected Boy( int boyno){
        this.boyno=boyno;
    }


}

class BoyGame{
    public Boy first=new Boy(-1);
    public Boy text=null;
    public void  addBoy(int boynum){
        if(boynum<1){
            return;
        }

        for (int i=1;i<boynum;i++){
            Boy boy = new Boy(i);
            if(i==1){

                first=boy;
                first.next=first;
                text=boy;


            }else {
               text.next=boy;
               boy.next=first;
                text=boy;
            }
        }
    }
  public void show (){
        if(first.next==null){
            System.out.println("还没添加任何小孩");

            return;
        }

        text=first;
      while (true){
          System.out.println(text.boyno);
          if(text.next==first){

              break;

          }
          text=text.next;
      }

  }


        }
