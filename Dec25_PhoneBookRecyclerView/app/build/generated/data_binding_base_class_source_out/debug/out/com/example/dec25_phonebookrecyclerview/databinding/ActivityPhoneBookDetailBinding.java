// Generated by view binder compiler. Do not edit!
package com.example.dec25_phonebookrecyclerview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.dec25_phonebookrecyclerview.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPhoneBookDetailBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button back;

  @NonNull
  public final TextView personDetailName;

  @NonNull
  public final TextView personDetailNumber;

  private ActivityPhoneBookDetailBinding(@NonNull LinearLayout rootView, @NonNull Button back,
      @NonNull TextView personDetailName, @NonNull TextView personDetailNumber) {
    this.rootView = rootView;
    this.back = back;
    this.personDetailName = personDetailName;
    this.personDetailNumber = personDetailNumber;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPhoneBookDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPhoneBookDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_phone_book_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPhoneBookDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.back;
      Button back = rootView.findViewById(id);
      if (back == null) {
        break missingId;
      }

      id = R.id.person_detail_name;
      TextView personDetailName = rootView.findViewById(id);
      if (personDetailName == null) {
        break missingId;
      }

      id = R.id.person_detail_number;
      TextView personDetailNumber = rootView.findViewById(id);
      if (personDetailNumber == null) {
        break missingId;
      }

      return new ActivityPhoneBookDetailBinding((LinearLayout) rootView, back, personDetailName,
          personDetailNumber);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
