// Generated by view binder compiler. Do not edit!
package com.example.dec25_phonebookrecyclerview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.dec25_phonebookrecyclerview.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PhonebookItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView personName;

  private PhonebookItemBinding(@NonNull LinearLayout rootView, @NonNull TextView personName) {
    this.rootView = rootView;
    this.personName = personName;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static PhonebookItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PhonebookItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.phonebook_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PhonebookItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.person_name;
      TextView personName = rootView.findViewById(id);
      if (personName == null) {
        break missingId;
      }

      return new PhonebookItemBinding((LinearLayout) rootView, personName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
