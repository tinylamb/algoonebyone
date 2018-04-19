package thread.producermodel;

import lombok.Data;

/**
 * Created by samo on 2018/4/19.
 *
 * @author samo
 * @date 2018/04/19
 */
@Data
public class Task {
    public int no;

    public Task(int no) {
        this.no = no;
    }

}
