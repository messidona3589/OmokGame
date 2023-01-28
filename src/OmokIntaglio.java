import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

class Image { //이미지 아이콘 모음
    static ImageIcon iconBasic = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/한칸.png");
    static ImageIcon iconWhite = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/백돌.png");
    static ImageIcon iconBlack = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/흑돌.png");
    static ImageIcon iconLefttopCorner = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/한칸lefttopCorner.png");
    static ImageIcon iconRighttopCorner = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/한칸righttopCorner.png");
    static ImageIcon iconLeftdownCorner = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/한칸leftdownCorner.png");
    static ImageIcon iconRightdownCorner = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/한칸rightdownCorner.png");
    static ImageIcon iconLeftEdge = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/한칸leftEdge.png");
    static ImageIcon iconRightEdge = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/한칸rightEdge.png");
    static ImageIcon iconTopEdge = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/한칸topEdge.png");
    static ImageIcon iconDownEdge = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/한칸downEdge.png");
    static ImageIcon iconBasicBig = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/한칸big.png");
    static ImageIcon iconWhiteLefttopCorner = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/백돌lefttopCorner.png");
    static ImageIcon iconWhiteRighttopCorner = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/백돌righttopCorner.png");
    static ImageIcon iconWhiteLeftdownCorner = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/백돌leftdownCorner.png");
    static ImageIcon iconWhiteRightdownCorner = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/백돌rightdownCorner.png");
    static ImageIcon iconWhiteLeftEdge = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/백돌leftEdge.png");
    static ImageIcon iconWhiteRightEdge = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/백돌rightEdge.png");
    static ImageIcon iconWhiteTopEdge = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/백돌topEdge.png");
    static ImageIcon iconWhiteDownEdge = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/백돌downEdge.png");
    static ImageIcon iconBlackLefttopCorner = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/흑돌lefttopCorner.png");
    static ImageIcon iconBlackRighttopCorner = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/흑돌righttopCorner.png");
    static ImageIcon iconBlackLeftdownCorner = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/흑돌leftdownCorner.png");
    static ImageIcon iconBlackRightdownCorner = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/흑돌rightdownCorner.png");
    static ImageIcon iconBlackLeftEdge = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/흑돌leftEdge.png");
    static ImageIcon iconBlackRightEdge = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/흑돌rightEdge.png");
    static ImageIcon iconBlackTopEdge = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/흑돌topEdge.png");
    static ImageIcon iconBlackDownEdge = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/흑돌downEdge.png");
    static ImageIcon iconNo = new ImageIcon("C:/Users/messi/IdeaProjects/OmokGame/src/image/금수.png");
}
class TimerSet{
    static int stopWatch = 30; //timer 시간세기
    static int stop = 0; //스톱? 고?
    void start(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (stopWatch==0){
                    if (OmokIntaglio.modeSelector==1) OmokFunction.aiMode(OmokIntaglio.turn);
                    else {
                        OmokIntaglio.turn = (OmokIntaglio.turn==1) ? 2 : 1;
                        OmokIntaglio.timerLabel.setIcon((OmokIntaglio.turn==1) ? Image.iconBlack : Image.iconWhite);
                    }
                    stopWatch = 30;
                    OmokIntaglio.timerCount.setText("남은 시간 : " + stopWatch);
                }
                else {
                    if (stop==0) {
                        stopWatch--;
                        OmokIntaglio.timerCount.setText("남은 시간 : " + stopWatch);
                    }
                }
            }
        };
        timer.schedule(task, 0, 1000);
    }
}
class OmokFunction{

    static int check6(int x, int y){
        int dx[][] = {{-1, 1}, {-1, 1}, {0, 0}, {1, -1}};
        int dy[][] = {{0, 0}, {1, -1}, {1, -1}, {1, -1}};
        for (int i=0;i<4;i++){
            int cnt = 0;
            for (int j=1;j<6;j++){
                int nx = x + dx[i][0]*j;
                int ny = y + dy[i][0]*j;

                if (0<=nx && nx<19 && 0<=ny && ny<19){
                    if (OmokIntaglio.buttonList[nx][ny]==1) cnt++;
                    else break;
                }
                else break;
            }
            for (int j=1;j<6;j++){
                int nx = x + dx[i][1]*j;
                int ny = y + dy[i][1]*j;

                if (0<=nx && nx<19 && 0<=ny && ny<19){
                    if (OmokIntaglio.buttonList[nx][ny]==1) cnt++;
                    else break;
                }
                else break;
            }
            if (cnt>=5){
                if (checkWin(x, y, 1)!=1){
                    System.out.printf("장목 6\n");
                    return 1;
                }
            }
        }

        return 0;
    }
    static int check44(int x, int y){
        int dx[] = {-1, 1, -1, 1, 0, 0, 1, -1};
        int dy[] = {0, 0, 1, -1, 1, -1, 1, -1};
        int four = 0;
        // 돌이 4에서 끝에 있는 경우
        for (int i=0;i<8;i++){
            if (0<=x-dx[i] && x-dx[i]<19 && 0<=y-dy[i] && y-dy[i]<19){
                if (OmokIntaglio.buttonList[x-dx[i]][y-dy[i]]==0){
                    for (int j=1;j<5;j++){
                        int nx = x + dx[i]*j;
                        int ny = y + dy[i]*j;

                        if (0<=nx && nx<19 && 0<=ny && ny<19){
                            if (OmokIntaglio.buttonList[nx][ny]==0 && j==4){
                                four++;
                            }
                            else if (OmokIntaglio.buttonList[nx][ny]==1){
                                continue;
                            }
                            else break;
                        } else break;
                    }
                }
            }
        }
        // 돌이 4에서 중간에 있는 경우
        for (int i=0;i<8;i++){
            int go = 0;
            for (int j=1;j<3;j++){
                int nx = x - dx[i]*j;
                int ny = y - dy[i]*j;

                if (0<=nx && nx<19 && 0<=ny && ny<19){
                    if (j==1 && OmokIntaglio.buttonList[nx][ny]==1) continue;
                    else if (j==2 && OmokIntaglio.buttonList[nx][ny]==0) go = 1;
                }
                else break;
            }
            if (go==0) continue;
            for (int j=1;j<4;j++){
                int nx = x + dx[i]*j;
                int ny = y + dy[i]*j;

                if (0<=nx && nx<19 && 0<=ny && ny<19){
                    if (OmokIntaglio.buttonList[nx][ny]==0 && j==3){
                        four++;
                    }
                    else if (OmokIntaglio.buttonList[nx][ny]==1){
                        continue;
                    }
                    else break;
                } else break;
            }
        }

        if (four>=2) {
            System.out.printf("4 X 4\n");
            return 1;
        }
        else return 0;
    }
    static int check33(int x, int y){
        int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};
        int dy[] = {1, 1, 0, -1, -1, -1, 0, 1};
        int three = 0;

        //돌이 3에서 끝에 있는 경우
        for (int i=0;i<8;i++){
            int go = 0;
            if (0<=x-dx[i] && x-dx[i]<19 && 0<=y-dy[i] && y-dy[i]<19){
                if (OmokIntaglio.buttonList[x-dx[i]][y-dy[i]]==0){
                    //붙은 3
                    for (int j=1;j<4;j++){
                        int nx = x + dx[i]*j;
                        int ny = y + dy[i]*j;

                        if (0<=nx && nx<19 && 0<=ny && ny<19){
                            if (OmokIntaglio.buttonList[nx][ny]==0 && j==3){
                                three++;
                                go = 1;
                            }
                            else if (OmokIntaglio.buttonList[nx][ny]==1) continue;
                            else break;
                        } else break;
                    }
                    //거짓금수 확인
                    if (go==1){
                        OmokIntaglio.buttonList[x][y] = 1;
                        if (check6(x-dx[i],y - dy[i])==1 || check44(x-dx[i],y - dy[i])==1 || check6(x+dx[i]*3,y+dy[i]*3)==1 || check44(x+dx[i]*3,y+dy[i]*3)==1){
                            go = 0;
                            three--;
                            OmokIntaglio.buttonList[x][y] = 0;
                        }
                        else {
                            System.out.printf("붙은 3 끝\n");
                            OmokIntaglio.buttonList[x][y] = 0;
                            continue;
                        }
                    }
                    //첫번째 빈칸
                    for (int j=1;j<5;j++){
                        int nx = x + dx[i]*j;
                        int ny = y + dy[i]*j;

                        if (0<=nx && nx<19 && 0<=ny && ny<19){
                            if (OmokIntaglio.buttonList[nx][ny]==0 && j==4){
                                three++;
                                go = 1;
                            }
                            else if (OmokIntaglio.buttonList[nx][ny]==0 && j==1) continue;
                            else if (OmokIntaglio.buttonList[nx][ny]==1) continue;
                            else break;
                        } else break;
                    }
                    //거짓금수 확인
                    if (go==1){
                        OmokIntaglio.buttonList[x][y] = 1;
                        if (check44(x-dx[i],y - dy[i])==1 || check44(x+dx[i],y+dy[i])==1){
                            go = 0;
                            three--;
                            OmokIntaglio.buttonList[x][y] = 0;
                        }
                        else {
                            System.out.printf("첫번재 빈칸 끝3\n");
                            OmokIntaglio.buttonList[x][y] = 0;
                            continue;
                        }
                    }
                    //두번째 빈칸
                    for (int j=1;j<5;j++){
                        int nx = x + dx[i]*j;
                        int ny = y + dy[i]*j;

                        if (0<=nx && nx<19 && 0<=ny && ny<19){
                            if (OmokIntaglio.buttonList[nx][ny]==0 && j==4){
                                three++;
                                go = 1;
                            }
                            else if (OmokIntaglio.buttonList[nx][ny]==0 && j==2) continue;
                            else if (OmokIntaglio.buttonList[nx][ny]==1) continue;
                            else break;
                        } else break;
                    }
                    //거짓금수 확인
                    if (go==1){
                        OmokIntaglio.buttonList[x][y] = 1;
                        if (check44(x-dx[i],y - dy[i])==1 || check44(x+dx[i]*2,y+dy[i]*2)==1){
                            go = 0;
                            three--;
                            OmokIntaglio.buttonList[x][y] = 0;
                        }
                        else {
                            System.out.printf("두번째 빈칸 끝3\n");
                            OmokIntaglio.buttonList[x][y] = 0;
                            continue;
                        }
                    }
                }
            }
        }

        //돌이 3에서 가운데 있는 경우
        for (int i=0;i<8;i++){
            int go = 0;
            int close = 0;
            // 반대쪽 체크
            for (int j=1;j<4;j++){
                int nx = x - dx[i]*j;
                int ny = y - dy[i]*j;

                if (0<=nx && nx<19 && 0<=ny && ny<19){
                    if (OmokIntaglio.buttonList[nx][ny]==1 && j==1) continue;
                    else if (OmokIntaglio.buttonList[nx][ny]==0 && j==2) go++;
                    else if (OmokIntaglio.buttonList[nx][ny]==2 && j==3) close++;
                    else break;
                } else break;
            }
            if (go==0) continue;

            // 붙은 3 - 대칭 조심
            if (i<=3){
                for (int j=1;j<4;j++){
                    int nx = x + dx[i]*j;
                    int ny = y + dy[i]*j;

                    if (0<=nx && nx<19 && 0<=ny && ny<19){
                        if (OmokIntaglio.buttonList[nx][ny]==1 && j==1) continue;
                        else if (OmokIntaglio.buttonList[nx][ny]==0 && j==2) {
                            three++;
                            go++;
                        }
                        else if (OmokIntaglio.buttonList[nx][ny]==2 && j==3) close++;
                        else break;
                    } else break;
                }
                //거짓금수 확인
                if (go==2){
                    OmokIntaglio.buttonList[x][y] = 1;
                    if (close==2 || check6(x-dx[i]*2,y - dy[i]*2)==1 || check44(x-dx[i]*2,y - dy[i]*2)==1 || check6(x+dx[i]*2,y+dy[i]*2)==1 || check44(x+dx[i]*2,y+dy[i]*2)==1){
                        go = 1;
                        three--;
                        OmokIntaglio.buttonList[x][y] = 0;
                    }
                    else {
                        System.out.printf("붙은 3 가운데\n");
                        OmokIntaglio.buttonList[x][y] = 0;
                        continue;
                    }
                }
            }

            //떨어진 3
            for (int j=1;j<4;j++){
                int nx = x + dx[i]*j;
                int ny = y + dy[i]*j;

                if (0<=nx && nx<19 && 0<=ny && ny<19){
                    if (OmokIntaglio.buttonList[nx][ny]==0 && j==1) continue;
                    else if (OmokIntaglio.buttonList[nx][ny]==1 && j==2) continue;
                    else if (OmokIntaglio.buttonList[nx][ny]==0 && j==3){
                        three++;
                        go++;
                    }
                    else break;
                } else break;
            }
            //거짓금수 확인
            if (go==2){
                OmokIntaglio.buttonList[x][y] = 1;
                if (check44(x+dx[i]*2,y+dy[i]*2)==1){
                    go = 1;
                    three--;
                    OmokIntaglio.buttonList[x][y] = 0;
                }
                else {
                    System.out.printf("떨어진 3 가운데\n");
                    OmokIntaglio.buttonList[x][y] = 0;
                    continue;
                }
            }
        }

        if (three>=2) return 1;
        else return 0;
    }
    static int checkWin(int x, int y, int turn){
        int dx[][] = {{-1, 1}, {-1, 1}, {0, 0}, {1, -1}};
        int dy[][] = {{0, 0}, {1, -1}, {1, -1}, {1, -1}};
        for (int i=0;i<4;i++){
            int cnt = 1;
            for (int j=1;j<5;j++){
                int nx = x + dx[i][0]*j;
                int ny = y + dy[i][0]*j;
                if (0<=nx && nx<19 && 0<=ny && ny<19){
                    if (OmokIntaglio.buttonList[nx][ny] == turn) cnt++;
                    else break;
                } else break;
            }
            for (int j=1;j<5;j++){
                int nx = x + dx[i][1]*j;
                int ny = y + dy[i][1]*j;
                if (0<=nx && nx<19 && 0<=ny && ny<19){
                    if (OmokIntaglio.buttonList[nx][ny]==turn) cnt++;
                    else break;
                } else break;
            }
            if (cnt==5) return 1;
        }
        return 0;
    }
    static void aiMode(int turn){

        // 1인용 모드(AI 상대하기) vs 2인용 모드
        //1. 4개 이상 있으면 (4+0, 3+1, 2+2) 내꺼+1000 / 상대+500
        //2. 양쪽이 막히지 않은 3개의 돌.(3+0, 2+1) 내꺼+100 /상대 +50
        //3. 내 돌 근처+2
        //4. 상대 돌 근처+1
        //5. 못찾으면 가운데

        int dx[][] = {{-1, 1}, {-1, 1}, {0, 0}, {1, -1}};
        int dy[][] = {{0, 0}, {1, -1}, {1, -1}, {1, -1}};
        int pointArray[][] = new int[19][19];
        int aiTurn = (turn==1) ? 2: 1;

        //금수와 이미 돌 있는 곳 금지
        for (int i=0;i<19;i++){
            for (int j=0;j<19;j++){
                if (aiTurn==1 && (check33(i, j)==1 || check44(i, j)==1) || check6(i, j)==1) pointArray[i][j] = -1;
                else if (OmokIntaglio.buttonList[i][j]!=0) pointArray[i][j]= -1;
            }
        }

        for (int i=0;i<19;i++){
            for (int j=0;j<19;j++){
                //1. 4개이상 이어져있을 시 우선순위로 막는다.(4+0, 3+1, 2+2)
                //2. 양쪽이 막히지 않은 3개의 돌 막음.(3+0, 2+1)
                if (OmokIntaglio.buttonList[i][j] == 0){
                    if (pointArray[i][j] != -1){
                        for (int k=0;k<4;k++){
                            //내꺼 기준
                            int aiCnt = 0;
                            int aiBlank = 0;
                            for (int l=1;l<5;l++){
                                int nx = i + dx[k][0]*l;
                                int ny = j + dy[k][0]*l;
                                if (0<=nx && nx<19 && 0<=ny && ny<19){
                                    if (OmokIntaglio.buttonList[nx][ny]==aiTurn) aiCnt++;
                                    else if (OmokIntaglio.buttonList[nx][ny]==0){
                                        aiBlank++;
                                        break;
                                    }
                                    else break;
                                }
                                else break;
                            }
                            for (int l=1;l<5;l++){
                                int nx = i + dx[k][1]*l;
                                int ny = j + dy[k][1]*l;
                                if (0<=nx && nx<19 && 0<=ny && ny<19){
                                    if (OmokIntaglio.buttonList[nx][ny]==aiTurn) aiCnt++;
                                    else if (OmokIntaglio.buttonList[nx][ny]==0){
                                        aiBlank++;
                                        break;
                                    }
                                    else break;
                                }
                                else break;
                            }
                            if (aiCnt>=4) { //1
                                pointArray[i][j] += 1000;
                            }
                            else if (aiCnt==3 && aiBlank==2){ //2
                                pointArray[i][j] += 100;
                            }
                            //상대꺼 기준
                            int playerCnt = 0;
                            int playerBlank = 0;
                            for (int l=1;l<5;l++){
                                int nx = i + dx[k][0]*l;
                                int ny = j + dy[k][0]*l;
                                if (0<=nx && nx<19 && 0<=ny && ny<19){
                                    if (OmokIntaglio.buttonList[nx][ny]==turn) playerCnt++;
                                    else if (OmokIntaglio.buttonList[nx][ny]==0){
                                        playerBlank++;
                                        break;
                                    }
                                    else break;
                                }
                                else break;
                            }
                            for (int l=1;l<5;l++){
                                int nx = i + dx[k][1]*l;
                                int ny = j + dy[k][1]*l;
                                if (0<=nx && nx<19 && 0<=ny && ny<19){
                                    if (OmokIntaglio.buttonList[nx][ny]==turn) playerCnt++;
                                    else if (OmokIntaglio.buttonList[nx][ny]==0){
                                        playerBlank++;
                                        break;
                                    }
                                    else break;
                                }
                                else break;
                            }
                            if (playerCnt>=4) { //1
                                pointArray[i][j] += 500;
                            }
                            else if (playerCnt==3 && playerBlank==2){ //2
                                pointArray[i][j] += 50;
                            }
                        }
                    }
                }
                else {
                    for (int k=0;k<4;k++){ //현재 돌 주변으로 더해줌
                        for (int l=0;l<2;l++){
                            int nx = i + dx[k][l];
                            int ny = j + dy[k][l];
                            if (0<=nx && nx<19 && 0<=ny && ny<19){
                                if (pointArray[nx][ny]!= -1){
                                    if (OmokIntaglio.buttonList[i][j]==aiTurn) pointArray[nx][ny]+=2;
                                    else pointArray[nx][ny]+=1;
                                }
                            }
                        }
                    }
                }
            }
        }

        //가중치 중 가장 높은 곳에 착수
        int max = 0;
        int put[] = {9, 9};
        for (int i=0;i<19;i++){
            for (int j=0;j<19;j++){
                System.out.printf(" " + pointArray[i][j]);
                if (pointArray[i][j]!=-1 && pointArray[i][j] > max){
                    put[0] = i;
                    put[1] = j;
                    max = pointArray[i][j];
                }
            }
            System.out.printf("\n");
        }
        System.out.printf("----------------------------\n");

        //결정 후 착수 조치
        int i = put[0], j = put[1];
        OmokIntaglio.buttonList[i][j] = aiTurn;
        OmokIntaglio.record[OmokIntaglio.len][0] = put[0];
        OmokIntaglio.record[OmokIntaglio.len][1] = put[1];
        OmokIntaglio.len++;
        OmokIntaglio.cntTurn++;
        if (aiTurn==1) ChangeColor.blackColor(i, j);
        else ChangeColor.whiteColor(i, j);

        if (checkWin(i, j, aiTurn)==1) { //승리 조건 체크
            String option[] = {"다시하기", "종료"};
            OmokIntaglio.timerSet.stop = 1;
            int answer;
            if (OmokIntaglio.buttonList[i][j] == 1) answer = JOptionPane.showOptionDialog(null, "흑돌 승리!", "Game Over", 0, 0, Image.iconBlack, option, option[0]);
            else answer = JOptionPane.showOptionDialog(null, "백돌 승리!", "Game Over", 0, 0, Image.iconWhite, option, option[0]);

            if (answer == 0) restart();
            else System.exit(0); //이기는 조건 체크
        }
        if (OmokIntaglio.cntTurn==361) JOptionPane.showMessageDialog(null, "비김!"); //비기는 조건 체크
        OmokIntaglio.timerSet.stopWatch = 30;
        OmokIntaglio.timerCount.setText("남은 시간 : " + OmokIntaglio.timerSet.stopWatch);
    }
    static void restart(){ //다시하기 함수
        if (OmokIntaglio.modeSelector==1) OmokIntaglio.timerLabel.setIcon((OmokIntaglio.turn==1) ? Image.iconBlack : Image.iconWhite);
        else {
            OmokIntaglio.turn=1;
            OmokIntaglio.timerLabel.setIcon(Image.iconBlack);
        }

        OmokIntaglio.cntTurn = 0;
        OmokIntaglio.timerSet.stopWatch = 30;
        OmokIntaglio.timerSet.stop = 0;
        OmokIntaglio.timerCount.setText("남은 시간 : " + OmokIntaglio.timerSet.stopWatch);
        OmokIntaglio.len = 0;

        //바둑판 초기화
        for (int i=0;i<19;i++) {
            for (int j = 0; j < 19; j++) {
                ChangeColor.originalColor(i, j);
                OmokIntaglio.buttonList[i][j] = 0;
            }
        }
        if (OmokIntaglio.modeSelector==1 && OmokIntaglio.turn==2) aiMode(OmokIntaglio.turn);
    }
}
class ChangeColor{
    static void originalColor(int i, int j){
        if (i==0){ //원래 바둑판 한칸으로
            if (j==0) OmokIntaglio.buttons[i][j].setIcon(Image.iconLefttopCorner);
            else if (j==18) OmokIntaglio.buttons[i][j].setIcon(Image.iconRighttopCorner);
            else {OmokIntaglio.buttons[i][j].setIcon(Image.iconTopEdge);}
        } else if (i==18){
            if (j==0) OmokIntaglio.buttons[i][j].setIcon(Image.iconLeftdownCorner);
            else if (j==18) OmokIntaglio.buttons[i][j].setIcon(Image.iconRightdownCorner);
            else {OmokIntaglio.buttons[i][j].setIcon(Image.iconDownEdge);}
        } else {
            if (j==0) OmokIntaglio.buttons[i][j].setIcon(Image.iconLeftEdge);
            else if (j==18) OmokIntaglio.buttons[i][j].setIcon(Image.iconRightEdge);
            else {
                if ((i==3 && (j==3 || j==9 || j==15)) || (i==9 && (j==3 || j==9 || j==15)) || (i==15 && (j==3 || j==9 || j==15))){
                    OmokIntaglio.buttons[i][j].setIcon(Image.iconBasicBig);
                }
                else {OmokIntaglio.buttons[i][j].setIcon(Image.iconBasic);}
            }
        }
    }
    static void blackColor(int i, int j){
        if (i==0){
            if (j==0) OmokIntaglio.buttons[i][j].setIcon(Image.iconBlackLefttopCorner);
            else if (j==18) OmokIntaglio.buttons[i][j].setIcon(Image.iconBlackRighttopCorner);
            else {OmokIntaglio.buttons[i][j].setIcon(Image.iconBlackTopEdge);}
        } else if (i==18){
            if (j==0) OmokIntaglio.buttons[i][j].setIcon(Image.iconBlackLeftdownCorner);
            else if (j==18) OmokIntaglio.buttons[i][j].setIcon(Image.iconBlackRightdownCorner);
            else {OmokIntaglio.buttons[i][j].setIcon(Image.iconBlackDownEdge);}
        } else {
            if (j == 0) OmokIntaglio.buttons[i][j].setIcon(Image.iconBlackLeftEdge);
            else if (j == 18) OmokIntaglio.buttons[i][j].setIcon(Image.iconBlackRightEdge);
            else {OmokIntaglio.buttons[i][j].setIcon(Image.iconBlack);}
        }
    }
    static void whiteColor(int i, int j){
        if (i==0){
            if (j==0) OmokIntaglio.buttons[i][j].setIcon(Image.iconWhiteLefttopCorner);
            else if (j==18) OmokIntaglio.buttons[i][j].setIcon(Image.iconWhiteRighttopCorner);
            else {OmokIntaglio.buttons[i][j].setIcon(Image.iconWhiteTopEdge);}
        } else if (i==18){
            if (j==0) OmokIntaglio.buttons[i][j].setIcon(Image.iconWhiteLeftdownCorner);
            else if (j==18) OmokIntaglio.buttons[i][j].setIcon(Image.iconWhiteRightdownCorner);
            else {OmokIntaglio.buttons[i][j].setIcon(Image.iconWhiteDownEdge);}
        } else {
            if (j == 0) OmokIntaglio.buttons[i][j].setIcon(Image.iconWhiteLeftEdge);
            else if (j == 18) OmokIntaglio.buttons[i][j].setIcon(Image.iconWhiteRightEdge);
            else {OmokIntaglio.buttons[i][j].setIcon(Image.iconWhite);}
        }
    }
}
public class OmokIntaglio {
    // 초기화 변수 설정
    static int buttonList[][] = new int[19][19]; //0, 1, 2로 이루어진 바둑판
    static int turn = 1; // 흑돌=1, 흰돌=2, 시작은 흑돌부터 그리고 aiTurn은 반대로 설정
    static int cntTurn = 0; //turn 횟수 세기
    static JButton buttons[][] = new JButton[19][19]; //버튼 배열
    static int record[][] = new int[361][2]; //한 수 무르기 때 필요한 기록 배열
    static int len = 0; //record 배열의 index
    static int modeSelector = 1; //1=AI모드, 2=2인용모드
    static TimerSet timerSet = new TimerSet(); //TimerSet 불러오기
    static JLabel timerLabel = new JLabel(Image.iconBlack);
    static JLabel timerCount = new JLabel("남은 시간 : " + timerSet.stopWatch);

    public static void main(String [] args) {
        JFrame frame = new JFrame(); //기본 프레임

        //오목판 panel
        JPanel omokPanel = new JPanel();
        omokPanel.setBounds(15, 0, 750, 750);
        omokPanel.setLayout(new GridLayout(19, 19));

        //타이머 panel
        JPanel timerPanel = new JPanel();
        timerPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5)));
        timerPanel.add(timerLabel);
        timerPanel.add(timerCount);
        timerPanel.setBounds(250, 770, 300, 70);
        timerSet.start();

        //한수 무르기 panel
        JPanel stepBackPanel = new JPanel(); //한수 무르기 panel
        JButton stepBackButton = new JButton("한 수 무르기");
        stepBackButton.setSize(150, 150);
        stepBackButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (len==0 || (len==1 && turn==2)) { //돌이 없거나 최종 돌 하나밖에 없으면 불가
                    JOptionPane.showMessageDialog(null, "한 수 무르기 불가!");
                    return;
                }

                //2인용 게임에서 한 수 무르기
                int i = record[len-1][0], j = record[len-1][1];
                buttonList[i][j] = 0;
                if (modeSelector==2){
                    turn = (turn==1) ? 2 : 1;
                    timerSet.stopWatch = 30;
                    timerCount.setText("남은 시간 : " + timerSet.stopWatch);
                    timerLabel.setIcon((turn==1) ? Image.iconBlack : Image.iconWhite);
                }
                cntTurn--;
                len--;
                ChangeColor.originalColor(i, j);

                //AI모드에서는 한번 더 한 수 무르기
                if (modeSelector==1){
                    i = record[len-1][0];
                    j = record[len-1][1];
                    buttonList[i][j] = 0;
                    cntTurn--;
                    len--;
                    ChangeColor.originalColor(i, j);
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        stepBackPanel.add(stepBackButton);
        stepBackPanel.setBounds(600, 770, 150, 70);

        //모드 변경 panel
        JPanel modePanel = new JPanel();
        JButton modeButton = new JButton("모드 변경");
        modeButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String option[] = {"AI 모드", "2인용 모드"};
                timerSet.stop = 1;
                int answer = JOptionPane.showOptionDialog(null, "모드 선택?", "모드 선택", 0, 0, Image.iconBasic, option, option[0]);
                if (answer==0) {
                    modeSelector = 1;
                    frame.setTitle("오목게임 AI 모드");
                    String orderOption[] = {"흑", "백"};
                    int order = JOptionPane.showOptionDialog(null, "흑 or 백?", "순서 정하기", 0, 0, Image.iconBasic, orderOption, orderOption[0]);
                    if (order==0) turn = 1;
                    else turn = 2;
                }
                else {
                    modeSelector=2;
                    frame.setTitle("오목게임 2인용 모드");
                }
                timerSet.stop = 0;
                OmokFunction.restart();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        modePanel.add(modeButton);
        modePanel.setBounds(50, 770, 150, 70);

        //기본적인 바둑판 만들기
        for (int i=0;i<19;i++){
            for (int j=0;j<19;j++){
                if (i==0){ //원래 바둑판 한칸으로
                    if (j==0) buttons[i][j] = new JButton(Image.iconLefttopCorner);
                    else if (j==18) buttons[i][j] = new JButton(Image.iconRighttopCorner);
                    else {buttons[i][j] = new JButton(Image.iconTopEdge);}
                } else if (i==18){
                    if (j==0) buttons[i][j] = new JButton(Image.iconLeftdownCorner);
                    else if (j==18) buttons[i][j] = new JButton(Image.iconRightdownCorner);
                    else {buttons[i][j] = new JButton(Image.iconDownEdge);}
                } else {
                    if (j==0) buttons[i][j] = new JButton(Image.iconLeftEdge);
                    else if (j==18) buttons[i][j] = new JButton(Image.iconRightEdge);
                    else {
                        if ((i==3 && (j==3 || j==9 || j==15)) || (i==9 && (j==3 || j==9 || j==15)) || (i==15 && (j==3 || j==9 || j==15))){
                            buttons[i][j] = new JButton(Image.iconBasicBig);
                        }
                        else {buttons[i][j] = new JButton(Image.iconBasic);}
                    }
                }

                //버튼 이벤트 설정
                buttons[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JButton buttonInfo = (JButton)e.getSource();
                        for (int i=0;i<19;i++){
                            for (int j=0;j<19;j++){
                                if (buttonInfo==buttons[i][j]){
                                    if (buttonList[i][j]==0){
                                        if (turn==1){
                                            if (OmokFunction.check33(i, j)==1){
                                                JOptionPane.showMessageDialog(null, "3 X 3!");
                                                return;
                                            }
                                            else if (OmokFunction.check44(i, j)==1){
                                                JOptionPane.showMessageDialog(null, "4 X 4!");
                                                return;
                                            }
                                            else if (OmokFunction.check6(i, j)==1){
                                                JOptionPane.showMessageDialog(null, "장목 6이상 불가!");
                                                return;
                                            }
                                        }

                                        buttonList[i][j] = turn;
                                        record[len][0] = i;
                                        record[len][1] = j;
                                        len++;
                                        cntTurn++;

                                        if (OmokFunction.checkWin(i, j, turn)==1){ //승리 조건 체크
                                            if (turn==1){
                                                ChangeColor.blackColor(i, j);
                                                if (modeSelector == 2) turn = 2;
                                            } else {
                                                ChangeColor.whiteColor(i, j);
                                                if (modeSelector == 2) turn = 1;
                                            }
                                            String option[] = {"다시하기", "종료"};
                                            timerSet.stop = 1;
                                            int answer;
                                            if (buttonList[i][j]==1) {answer = JOptionPane.showOptionDialog(null, "흑돌 승리!", "Game Over", 0, 0, Image.iconBlack, option, option[0]);}
                                            else {answer = JOptionPane.showOptionDialog(null, "백돌 승리!", "Game Over", 0, 0, Image.iconWhite, option, option[0]);}

                                            if (answer==0) OmokFunction.restart();
                                            else System.exit(0);
                                        } else if (cntTurn==361) {
                                            if (turn==1){
                                                ChangeColor.blackColor(i, j);
                                                if (modeSelector == 2) turn = 2;
                                            } else {
                                                ChangeColor.whiteColor(i, j);
                                                if (modeSelector == 2) turn = 1;
                                            }
                                            JOptionPane.showMessageDialog(null, "비김!"); //비기는 조건 체크
                                            String option[] = {"다시하기", "종료"};
                                            timerSet.stop = 1;
                                            int answer = JOptionPane.showOptionDialog(null, "비겼습니다!", "Game Over", 0, 0, Image.iconBasic, option, option[0]);

                                            if (answer==0) OmokFunction.restart();
                                            else System.exit(0);
                                        } else {
                                            if (turn==1){
                                                ChangeColor.blackColor(i, j);
                                                if (modeSelector == 2) turn = 2;
                                            } else {
                                                ChangeColor.whiteColor(i, j);
                                                if (modeSelector == 2) turn = 1;
                                            }
                                            if (modeSelector==1) OmokFunction.aiMode(turn);
                                            else {
                                                timerSet.stopWatch = 30;
                                                timerCount.setText("남은 시간 : " + timerSet.stopWatch);
                                                timerLabel.setIcon((turn==1) ? Image.iconBlack : Image.iconWhite);
                                            }
                                        }
                                        return;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "이미 돌 있음!");
                                    }
                                }
                            }
                        }
                    } //사용자가 컴포넌트를 클릭한 경우에 호출

                    @Override
                    public void mousePressed(MouseEvent e) {} //마우스가 컴포넌트위에서 눌려지면 호출

                    @Override
                    public void mouseReleased(MouseEvent e) {} //마우스가 컴포넌트 위에서 떼어지면 호출

                    @Override
                    public void mouseEntered(MouseEvent e) { //마우스커서가 컴포넌트로 들어가면 호출
                        JButton buttonInfo = (JButton)e.getSource();
                        for (int i=0;i<19;i++) {
                            for (int j = 0; j < 19; j++) {
                                if (buttonInfo == buttons[i][j]){
                                    if (buttonList[i][j]==0){
                                        if (turn==1){
                                            if (OmokFunction.check33(i, j)==1 || OmokFunction.check44(i, j)==1 || OmokFunction.check6(i, j)==1) {
                                                buttons[i][j].setIcon(Image.iconNo);
                                                return;
                                            }
                                        }
                                        if (turn==1) ChangeColor.blackColor(i, j);
                                        else ChangeColor.whiteColor(i, j);
                                    }
                                }
                            }
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) { //마우스 커서가 컴포넌트에서 나가면 호출
                        JButton buttonInfo = (JButton)e.getSource();
                        for (int i=0;i<19;i++) {
                            for (int j = 0; j < 19; j++) {
                                if (buttonInfo == buttons[i][j]){
                                    if (buttonList[i][j]==0){
                                        ChangeColor.originalColor(i, j);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                });
                buttons[i][j].setBorderPainted(false);
                buttons[i][j].setLayout(null);
                buttons[i][j].setSize(40, 40);
                omokPanel.add(buttons[i][j]);
            }
        }

        //AI 모드이고 흑돌이면 먼저 실행, 아이콘 플레이어로 바꿈
        if (modeSelector==1){
            if (turn==2) {
                OmokFunction.aiMode(turn);
                timerLabel.setIcon(Image.iconWhite);
            } else {
                turn = 1;
                timerLabel.setIcon(Image.iconBlack);
            }
        }

        frame.add(modePanel);
        frame.add(stepBackPanel);
        frame.add(timerPanel);
        frame.add(omokPanel);
        frame.setResizable(false); //프레임 크기 고정
        frame.setLocationRelativeTo(null); //프레임 화면 가운데 위치
        frame.getContentPane().setLayout(null); //프레임 레이아웃 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료 시 삭제
        frame.setTitle("오목 게임 AI 모드"); //프레임 상태바 제목 처음에는 AI모드
        frame.setSize(800, 900); //프레임 크기
        frame.setVisible(true); //프레임 기본적으로 보이게 하기
    }
}