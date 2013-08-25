/**
* Android ownCloud News
*
* @author David Luhmer
* @copyright 2013 David Luhmer david-dev@live.de
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU AFFERO GENERAL PUBLIC LICENSE
* License as published by the Free Software Foundation; either
* version 3 of the License, or any later version.
*
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU AFFERO GENERAL PUBLIC LICENSE for more details.
*
* You should have received a copy of the GNU Affero General Public
* License along with this library.  If not, see <http://www.gnu.org/licenses/>.
*
*/

package de.luhmer.owncloudnewsreader.async_tasks;

import android.os.AsyncTask;
import android.widget.TextView;

public class FillTextForTextViewAsyncTask extends AsyncTask<Void, Void, String> {
	IGetTextForTextViewAsyncTask iGetter;
	TextView textView;
	
	public FillTextForTextViewAsyncTask(TextView textView, IGetTextForTextViewAsyncTask iGetter)
	{
		this.iGetter = iGetter;
		this.textView = textView; 
	}
	
	@Override
	protected String doInBackground(Void... params) {
		return iGetter.getText();
	}
	
	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */
	@Override
	protected void onPostExecute(String result) {
		if(result != null)
			if(!result.equals("0"))
				textView.setText(result);
		super.onPostExecute(result);
	}
}
