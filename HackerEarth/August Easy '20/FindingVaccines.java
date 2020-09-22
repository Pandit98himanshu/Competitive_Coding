import java.io.*;
import java.util.*;
import java.lang.*;

class FindingVaccines {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int n = Integer.parseInt(in.readLine());
		int virusLen = 	Integer.parseInt(in.readLine());
		String virus = in.readLine();
		Count virusCount = getCount(virus, virusLen);

		long maxInteraction = 0, vaccineNumber = 0;
		for (int i = 1; i <= n; i++) {
			int vaccineLen = Integer.parseInt(in.readLine());
			String vaccine = in.readLine();
			Count vaccineCount = getCount(vaccine, vaccineLen);

			long interaction = virusCount.G * vaccineCount.C
							+ virusCount.C * vaccineCount.G;

			if (maxInteraction < interaction) {
				maxInteraction = interaction;
				vaccineNumber = i;
			}
		}
		out.println(vaccineNumber);
        out.close();
	}
	static Count getCount(String s, int n) {
		Count obj = new Count();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'G') {
				obj.G++;
			}
			else if (s.charAt(i) == 'C') {
				obj.C++;
			}
		}
		return obj;
	}

	static class Count {
        int G;
        int C;

        public Count () {
            this.G = 0;
            this.C = 0;
        }
		@Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Count count = (Count) o;
            return G == count.G && C == count.C;
        }
        @Override
        public String toString() {
            return "G = " + G + ", C = " + C;
        }
    }
}	

