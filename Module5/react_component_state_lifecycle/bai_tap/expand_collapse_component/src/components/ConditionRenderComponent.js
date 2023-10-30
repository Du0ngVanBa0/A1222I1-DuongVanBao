import React from "react";
import "bootstrap/dist/css/bootstrap.css"

class ConditionRenderComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isExpand: false
        }
    }

    handleButton = () => {
        if (this.state.isExpand){
            this.setState({isExpand: false})
        }else{
            this.setState({isExpand: true})
        }
    }

    render() {
        return (
            <div>
                <div className="p-3 text-bg-success border border-primary-subtle rounded-3">
                    C0nditi0nal Rendering
                </div>
                {!this.state.isExpand
                    ? <button type="button" onClick={this.handleButton} className="btn btn-info">Xem giới thiệu</button>
                    : <div>
                        <button type="button" onClick={this.handleButton} className="btn btn-danger">Đóng giới thiệu</button>
                        <h1 className="display-3">Giới thiệu</h1>
                        <p>Người tôi gắn bó nhất trong gia đình là anh trai của tôi. Hiện tại, anh trai tôi đang là một sinh viên đại học. Anh tên là Tùng. Anh không chỉ đẹp trai mà còn học rất giỏi. Nếu nói đến học lực thì anh là một tấm gương điểm sáng để cho lũ trẻ em hàng xóm noi theo. Nhưng nhắc đến anh trai, tôi sẽ nghĩ về những trải nghiệm cùng anh thực hiện khi còn nhỏ.

                            Nhớ nhất là khi tôi lên năm tuổi, anh trai đã đưa tôi đi câu cá ở con sông gần làng. Đây là lần đầu tiên tôi được đi câu cá. Chính vì vậy, tôi cảm thấy rất háo hức. Đầu tiên, hai anh em đã đi ra vườn để đào giun đất làm mồi câu. Sau đó, cả hai cùng nhau ra sông câu cá. Anh Tùng đã dạy tôi cách gắn mồi câu, cách câu cá. Khi nhìn anh làm, tôi cảm thấy vô cùng khâm phục. Anh trai của tôi thật giỏi. Chúng tôi đã ngồi câu rất lâu. Vì là lần đầu tiên, nên tôi còn gặp phải nhiều khó khăn. Từ việc gắn lưỡi câu, mồi câu… Nhưng nhờ có anh Tùng kiên nhẫn dạy mà lần đầu tiên tôi đã câu được một con cá. Đó là một trải nghiệm thật tuyệt với tôi.

                            Bố mẹ bận rộn công việc, anh trai là người luôn dạy cho tôi nhiều điều bổ ích. Không chỉ giảng bài cho tôi, anh còn dạy tôi học võ nữa. Anh bảo con gái phải biết tự bảo vệ bản thân mình. Biết bao nhiêu là kỉ niệm đẹp đẽ như vừa mới xảy ra thôi. Những năm anh học đại học, phải xa nhà thường xuyên, tôi thấy nhớ anh. Nhớ những lúc anh nấu cơm dỗ tôi ăn khi tôi bị ốm còn bố mẹ bận công chuyện, những lần anh dạy tôi học bài… Nhờ có anh mà tuổi thơ của tôi luôn cảm thấy hạnh phúc.

                            Đối với tôi, anh trai là một người vô cùng quan trọng. Tôi luôn dành cho anh sự yêu mến, tự hào. Và tôi mong rằng chúng tôi sẽ có thêm nhiều kỉ niệm hạnh phúc hơn nữa.</p>
                    </div>
                }
            </div>
        );
    }
}

export default ConditionRenderComponent