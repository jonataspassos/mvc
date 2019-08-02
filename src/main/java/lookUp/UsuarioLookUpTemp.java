package lookUp;

import bean.UsuarioBean;

public class UsuarioLookUpTemp extends UsuarioBean{
		private String phone;
		

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		@Override
		public String toString() {
			return "UsuarioLookUpTemp [id="
					+ getId() + ", login=" + getLogin() + ", phone=" + getPhone() + "]";
		}

		
		
	}
