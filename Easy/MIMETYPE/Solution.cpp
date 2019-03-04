#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;
typedef vector<string> myList;

/**
* Auto-generated code below aims at helping you parse
* the standard input according to the problem statement.
**/
int main()
{
	int N; // Number of elements which make up the association table.
	cin >> N; cin.ignore();
	int Q; // Number Q of file names to be analyzed.
	cin >> Q; cin.ignore();


	int searcher;
	bool found;

	myList fileExtention;
	myList mimeType;



	for (unsigned int i = 0; i < N; i++) {
		string EXT; // file extension
		string MT; // MIME type.
		cin >> EXT >> MT; cin.ignore();

		// Restriktionen + Alle Buchstaben Lower Case
		if (EXT.length() < 11 && MT.length() <51) {
			for (int j = 0; j < EXT.length(); j++) {
				EXT[j] = tolower(EXT[j]);
			}

			fileExtention.push_back(EXT);
			mimeType.push_back(MT);
            
            cerr << EXT << " " << MT <<endl;
		}


	}
	cerr << endl;
	for (unsigned int i = 0; i < Q; i++) {
		string FNAME; // One file name per line.
		string extFName = "";
		getline(cin, FNAME);
		// Restriktionen + Alle Buchstaben Lower Case
		if (FNAME.length() < 257) {

			int startExt = FNAME.rfind('.') + 1;

			if (startExt == -1 || startExt==0) {
				cout << "UNKNOWN" << endl;
				continue;
			}


			for (int j = startExt; j < FNAME.length(); j++) {
				extFName += tolower(FNAME[j]);
			}
            
            cerr << FNAME << " " << extFName << endl;
			// Geht alle FileExtentions durch
			for (unsigned int j = 0; j < N; j++) {
				int searcher = extFName.find(fileExtention[j]);;

				// Prüft ob das Word drinn vorkommt
				if (searcher != -1&& extFName.length()== fileExtention[j].length()){
					cout << mimeType[j] << std::endl; found = true; break;

				}
			}
			if (!found) {
				cout << "UNKNOWN" << endl;
			}
			else {
				found = false;
			}
		}
}}